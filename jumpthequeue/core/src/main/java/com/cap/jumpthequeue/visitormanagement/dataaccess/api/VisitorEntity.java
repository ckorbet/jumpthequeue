package com.cap.jumpthequeue.visitormanagement.dataaccess.api;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.cap.jumpthequeue.accesscodemanagement.dataaccess.api.AccessCodeEntity;
import com.cap.jumpthequeue.general.common.api.validation.EmailExtended;
import com.cap.jumpthequeue.general.common.api.validation.Phone;
import com.cap.jumpthequeue.general.dataaccess.api.ApplicationPersistenceEntity;
import com.cap.jumpthequeue.visitormanagement.common.api.Visitor;

/**
 * <p>
 * Entity class for Visitor table
 * </p>
 */
@Entity
@Table(name = "Visitor")
public class VisitorEntity extends ApplicationPersistenceEntity implements Visitor {

  @NotNull
  private String name;

  @NotNull
  @EmailExtended
  private String email;

  @NotNull
  @Phone
  private String phone;

  private AccessCodeEntity code;

  private static final long serialVersionUID = 1L;

  /**
   * @return name
   */
  public String getName() {

    return this.name;
  }

  /**
   * @param name new value of {@link #getname}.
   */
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return email
   */
  public String getEmail() {

    return this.email;
  }

  /**
   * @param email new value of {@link #getemail}.
   */
  public void setEmail(String email) {

    this.email = email;
  }

  /**
   * @return phone
   */
  public String getPhone() {

    return this.phone;
  }

  /**
   * @param phone new value of {@link #getphone}.
   */
  public void setPhone(String phone) {

    this.phone = phone;
  }

  /**
   * @return code
   */
  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "idCode")
  public AccessCodeEntity getCode() {

    return this.code;
  }

  /**
   * @param code new value of {@link #getcode}.
   */
  public void setCode(AccessCodeEntity code) {

    this.code = code;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.email == null) ? 0 : this.email.hashCode());
    result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
    result = prime * result + ((this.phone == null) ? 0 : this.phone.hashCode());
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
    VisitorEntity other = (VisitorEntity) obj;
    if (this.email == null) {
      if (other.email != null)
        return false;
    } else if (!this.email.equals(other.email))
      return false;
    if (this.name == null) {
      if (other.name != null)
        return false;
    } else if (!this.name.equals(other.name))
      return false;
    if (this.phone == null) {
      if (other.phone != null)
        return false;
    } else if (!this.phone.equals(other.phone))
      return false;
    return true;
  }

  @Override
  public String toString() {

    StringBuilder builder = new StringBuilder();
    builder.append("VisitorEntity [name=");
    builder.append(this.name);
    builder.append(", email=");
    builder.append(this.email);
    builder.append(", phone=");
    builder.append(this.phone);
    builder.append("]");
    return builder.toString();
  }

  @Override
  @Transient
  public Long getCodeId() {

    if (this.code == null) {
      return null;
    }
    return this.code.getId();
  }

  @Override
  public void setCodeId(Long codeId) {

    if (codeId == null) {
      this.code = null;
    } else {
      AccessCodeEntity accessCodeEntity = new AccessCodeEntity();
      accessCodeEntity.setId(codeId);
      this.code = accessCodeEntity;
    }
  }

}
