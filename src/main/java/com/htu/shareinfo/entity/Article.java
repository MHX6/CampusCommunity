package com.htu.shareinfo.entity;


import java.util.Date;

public class Article {

  private long aid;
  private String title;
  private String content;
  private String label;
  private Date createTime;
  private String viewCount;
  private String commentCount;
  private String likeCount;
  private long uid;

  public long getAid() {
    return aid;
  }

  public void setAid(long aid) {
    this.aid = aid;
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

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getViewCount() {
    return viewCount;
  }

  public void setViewCount(String viewCount) {
    this.viewCount = viewCount;
  }

  public String getCommentCount() {
    return commentCount;
  }

  public void setCommentCount(String commentCount) {
    this.commentCount = commentCount;
  }

  public String getLikeCount() {
    return likeCount;
  }

  public void setLikeCount(String likeCount) {
    this.likeCount = likeCount;
  }

  public long getUid() {
    return uid;
  }

  public void setUid(long uid) {
    this.uid = uid;
  }
}
