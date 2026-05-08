# Class Diagram

```mermaid
classDiagram
    package org.scoula.cli {
        class App {
            -List~MenuItem~ menu
            -Scanner scanner
            -boolean run
            +add(String label, Command command) void
            +run() void
            +exit() void
            -printMenu() void
            -getChoice() int
            -executeCommand(int choice) void
        }
        
        class Command {
            <<interface>>
            +execute()* void
        }
        
        class MenuItem {
            -String label
            -Command command
            +getLabel() String
            +getCommand() Command
        }
    }

    package org.scoula.travel.domain {
        class Travel {
            -Long no
            -String district
            -String title
            -String description
            -String address
            -String phone
            +getNo() Long
            +setNo(Long no) void
            +getDistrict() String
            +getTitle() String
            +getDescription() String
            +getAddress() String
            +getPhone() String
        }
    }

    package org.scoula.travel.dao {
        class TravelDao {
            -String FILE_PATH$
            -List~Travel~ travels
            -TravelDao instance$
            +getInstance()$ TravelDao
            -TravelDao()
            -loadTravels() List~Travel~
            +save() void
            +findAll() List~Travel~
            +getPage(int page) List~Travel~
            +getTotalPages() int
            +findById(Long no) Optional~Travel~
            +findByDistrict(String district) List~Travel~
            +search(String keyword) List~Travel~
            +create(Travel travel) void
            +update(Travel travel) void
            +delete(Long no) void
        }
    }

    package org.scoula.travel.service {
        class TravelService {
            -TravelDao dao
            -Scanner scanner
            +printAllList() void
            +printPageList() void
            +printDistrictList() void
            +printDetail() void
            +search() void
        }
    }

    %% Relationships
    App "1" *-- "many" MenuItem : contains
    MenuItem "1" o-- "1" Command : uses
    TravelService "1" o-- "1" TravelDao : uses
    TravelDao "1" o-- "many" Travel : manages
    TravelService ..> Travel : uses
```
