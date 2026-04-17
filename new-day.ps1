param(
    [Parameter(Mandatory=$true)]
    [string]$Subject,

    # Used for both folder suffix and TIL title.
    [Parameter(Mandatory=$true)]
    [string]$Title
)

$rootPath = if ($PSScriptRoot) { $PSScriptRoot } else { (Get-Location).Path }

# Find all day-XXX/day_XXX folders under root, then use max + 1.
$dayNumbers = @(
    Get-ChildItem -Path $rootPath -Directory -Recurse -ErrorAction SilentlyContinue |
    ForEach-Object {
        if ($_.Name -match '^day[-_](\d{1,})($|[-_])') {
            [int]$matches[1]
        }
    }
)

if ($dayNumbers.Count -gt 0) {
    $nextDay = ([int](($dayNumbers | Measure-Object -Maximum).Maximum)) + 1
} else {
    $nextDay = 1
}

if ([string]::IsNullOrWhiteSpace($Title)) {
    throw "Title must not be empty."
}

# Build folder-safe suffix from title.
$suffix = $Title.Trim().ToLower()
$suffix = $suffix -replace '\s+', '_'
$suffix = $suffix -replace '[\\/:*?"<>|]', ''
$suffix = $suffix -replace '_{2,}', '_'
$suffix = $suffix.Trim('_', '.')
if ([string]::IsNullOrWhiteSpace($suffix)) {
    $suffix = "untitled"
}

$dayFolder = "day_{0:D3}_$suffix" -f $nextDay
$today = Get-Date -Format "yyyy-MM-dd"

# Resolve $Subject to an absolute path so .NET methods use the correct base.
if (-not [System.IO.Path]::IsPathRooted($Subject)) {
    $Subject = Join-Path (Get-Location).Path $Subject
}
$fullPath = Join-Path -Path $Subject -ChildPath $dayFolder

if (Test-Path $fullPath) {
    throw "Folder already exists: $fullPath"
}

New-Item -ItemType Directory -Force -Path (Join-Path $fullPath "docs") | Out-Null
New-Item -ItemType Directory -Force -Path (Join-Path $fullPath "src") | Out-Null

$dayNum = "{0:D3}" -f $nextDay
$tilPath = Join-Path -Path $fullPath -ChildPath "docs\TIL.md"

$tilContent = @'
# {2}
## Day {0} - {1}

---
## 목차

## 목차 1

## 목차 2


## 정리

### 더 공부할 것

- [ ]

### 기억할 내용

'@ -f $dayNum, $today, $Title

# Write UTF-8 with BOM for better compatibility on Windows PowerShell/editors.
$utf8Bom = New-Object System.Text.UTF8Encoding($true)
[System.IO.File]::WriteAllText($tilPath, $tilContent, $utf8Bom)

Write-Host ""
Write-Host "Done." -ForegroundColor Green
Write-Host "   $fullPath\" -ForegroundColor Cyan
Write-Host "   docs\" -ForegroundColor Cyan
Write-Host "   src\" -ForegroundColor Cyan
Write-Host "   TIL.md" -ForegroundColor Cyan
Write-Host ""
Write-Host "   code $tilPath" -ForegroundColor Yellow
Write-Host ""


#.\new-day.ps1 -Subject ".\01_WEB\03_Vue" -Title "Vue"     