package com.cap.jumpthequeue.accesscodemanagement.dataaccess.api;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.cap.jumpthequeue.accesscodemanagement.common.api.AccessCode;
import com.cap.jumpthequeue.general.dataaccess.api.ApplicationPersistenceEntity;
import com.cap.jumpthequeue.visitormanagement.dataaccess.api.VisitorEntity;

/**
 * <p>
 * Entity class for AccessCode table
 * </p>
 */
@Entity
@Table(name = "AccessCode")
public class AccessCodeEntity extends ApplicationPersistenceEntity implements AccessCode {

  private String code;

  @Temporal(TemporalType.TIMESTAMP)
  private Timestamp dateAndTime;

  private VisitorEntity visitor;

  private static final long serialVersionUID = 1L;

  /**
   * @return code
   */
  public String getCode() {

    return this.code;
  }

  /**
   * @param code new value of {@link #getcode}.
   */
  public void setCode(String code) {

    this.code = code;
  }

  /**
   * @return dateAndTime
   */
  public Timestamp getDateAndTime() {

    return this.dateAndTime;
  }

  /**
   * @param dateAndTime new value of {@link #getDateAndTime}.
   */
  public void setDateAndTime(Timestamp dateAndTime) {

    this.dateAndTime = dateAndTime;
  }

  /**
   * @return visitor
   */
  @OneToOne
  @JoinColumn(name = "idVisitor")
  public VisitorEntity getVisitor() {

    return this.visitor;
  }

  /**
   * @param visitor new value of {@link #getvisitor}.
   */
  public void setVisitor(VisitorEntity visitor) {

    this.visitor = visitor;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.code == null) ? 0 : this.code.hashCode());
    result = prime * result + ((this.dateAndTime == null) ? 0 : this.dateAndTime.hashCode());
    result = prime * result + ((this.visitor == null) ? 0 : this.visitor.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    AccessCodeEntity other = (AccessCodeEntity) obj;
    if (this.code == null) {
      if (other.code != null)
        return false;
    } else if (!this.code.equals(other.code))
      return false;
    if (this.dateAndTime == null) {
      if (other.dateAndTime != null)
        return false;
    } else if (!this.dateAndTime.equals(other.dateAndTime))
      return false;
    if (this.visitor == null) {
      if (other.visitor != null)
        return false;
    } else if (!this.visitor.equals(other.visitor))
      return false;
    return true;
  }

  @Override
  public String toString() {

    StringBuilder builder = new StringBuilder();
    builder.append("AccessCodeEntity [code=");
    builder.append(this.code);
    builder.append(", dateAndTime=");
    builder.append(this.dateAndTime);
    builder.append(", visitor=");
    builder.append(this.visitor);
    builder.append("]");
    return builder.toString();
  }

  @Override
  @Transient
  public Long getVisitorId() {

    if (this.visitor == null) {
      return null;
    }
    return this.visitor.getId();
  }

  @Override
  public void setVisitorId(Long visitorId) {

    if (visitorId == null) {
      this.visitor = null;
    } else {
      VisitorEntity visitorEntity = new VisitorEntity();
      visitorEntity.setId(visitorId);
      this.visitor = visitorEntity;
    }
  }

}
