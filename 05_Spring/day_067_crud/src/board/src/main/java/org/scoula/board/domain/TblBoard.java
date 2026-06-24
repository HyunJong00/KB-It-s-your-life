package org.scoula.board.domain;


public class TblBoard {

  private long no;
  private String title;
  private String content;
  private String writer;
  private java.sql.Timestamp regDate;
  private java.sql.Timestamp updateDate;


  public long getNo() {
    return no;
  }

  public void setNo(long no) {
    this.no = no;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public String getWriter() {
    return writer;
  }

  public void setWriter(String writer) {
    this.writer = writer;
  }


  public java.sql.Timestamp getRegDate() {
    return regDate;
  }

  public void setRegDate(java.sql.Timestamp regDate) {
    this.regDate = regDate;
  }


  public java.sql.Timestamp getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(java.sql.Timestamp updateDate) {
    this.updateDate = updateDate;
  }

}
