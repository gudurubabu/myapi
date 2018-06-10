/**
 * 
 */
package com.bujair.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Bujair
 *
 */
@Entity
@Table(name = "CARD_INFO")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class CardInfo implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long cardID;
		
		@Column(nullable = false, unique = true)
		@NotNull(message="Bank Name should be valid")
		private String cardno;
		@NotNull(message="Bank Name should be valid")
		private String bankname;
		private String duedate;
		private double dueamount;
		private double availablebalance;
		private double creditLimit;
		private String bilgendate;
		private String pin;
		private String carduserid;
		private String branch;
		private String trnpwd;
		@NotNull(message="card type should be valid")
		private String cardtype;
		private String acno;
		
		
		@Column(nullable = false, updatable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    @CreatedDate
	    private Date createdAt;

	    @Column(nullable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    @LastModifiedDate
	    private Date updatedAt;
		
		public Date getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
		public Date getUpdatedAt() {
			return updatedAt;
		}
		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}
		public Long getCardID() {
			return cardID;
		}
		public void setCardID(Long cardID) {
			this.cardID = cardID;
		}
		public String getCardno() {
			return cardno;
		}
		public void setCardno(String cardno) {
			this.cardno = cardno;
		}
		public String getBankname() {
			return bankname;
		}
		public void setBankname(String bankname) {
			this.bankname = bankname;
		}
		public String getDuedate() {
			return duedate;
		}
		public void setDuedate(String duedate) {
			this.duedate = duedate;
		}
		public double getDueamount() {
			return dueamount;
		}
		public void setDueamount(double dueamount) {
			this.dueamount = dueamount;
		}
		public double getAvailablebalance() {
			return availablebalance;
		}
		public void setAvailablebalance(double availablebalance) {
			this.availablebalance = availablebalance;
		}
		public double getCreditLimit() {
			return creditLimit;
		}
		public void setCreditLimit(double creditLimit) {
			this.creditLimit = creditLimit;
		}
		public String getBilgendate() {
			return bilgendate;
		}
		public void setBilgendate(String bilgendate) {
			this.bilgendate = bilgendate;
		}
		public String getPin() {
			return pin;
		}
		public void setPin(String pin) {
			this.pin = pin;
		}
		public String getCarduserid() {
			return carduserid;
		}
		public void setCarduserid(String carduserid) {
			this.carduserid = carduserid;
		}
		public String getBranch() {
			return branch;
		}
		public void setBranch(String branch) {
			this.branch = branch;
		}
		public String getTrnpwd() {
			return trnpwd;
		}
		public void setTrnpwd(String trnpwd) {
			this.trnpwd = trnpwd;
		}
		public String getCardtype() {
			return cardtype;
		}
		public void setCardtype(String cardtype) {
			this.cardtype = cardtype;
		}
		public String getAcno() {
			return acno;
		}
		public void setAcno(String acno) {
			this.acno = acno;
		}
		
		
		
}
