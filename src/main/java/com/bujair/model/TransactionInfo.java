/**
 * 
 */
package com.bujair.model;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
@Table(name = "TRANS_INFO")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class TransactionInfo implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long transactioID;
		
		@NotNull(message="Transaction date should be valid")
		private double amount;
		
		@NotNull(message="Transaction date should be valid")
		//@Pattern(regexp="^\\d{4}-\\d{2}-\\d{2}$", message="Invalid Date type")
		private String  transDate;
		
		private String reason;
		@NotNull(message="Please mention who spent?")
		private String person;
		@NotNull(message="Please mention where you spent on?")
		private String spentOn;
		
		@Column(nullable = false, updatable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    @CreatedDate
	    private Date createdAt;

	    @Column(nullable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    @LastModifiedDate
	    private Date updatedAt;
	    
		public Long getTransactioID() {
			return transactioID;
		}
		public void setTransactioID(Long transactioID) {
			this.transactioID = transactioID;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		public String getTransDate() {
			return transDate;
		}
		public void setTransDate(String transDate) {
			this.transDate = transDate;
		}
		public String getReason() {
			return reason;
		}
		public void setReason(String reason) {
			this.reason = reason;
		}
		public String getPerson() {
			return person;
		}
		public void setPerson(String person) {
			this.person = person;
		}
		public String getSpentOn() {
			return spentOn;
		}
		public void setSpentOn(String spentOn) {
			this.spentOn = spentOn;
		}
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
		
		private String[] getFields() {
	        final List<String> lines = new ArrayList<>();    
	        for (final Field field: this.getClass().getFields()) {
	            field.setAccessible(true);
	            try {
	                lines.add(field.getName() + " = " + field.get(this));
	            } catch (final IllegalAccessException e) {
	                lines.add(field.getName() + " > " + e.getClass().getSimpleName());
	            }
	        }
	        return lines.toArray(new String[lines.size()]);
	    }
		@Override
	    public final String toString() {
	        final StringBuilder builder = new StringBuilder();
	        builder.append('(');
	        for (final String field : this.getFields()) {
	            builder.append(field);
	            builder.append(", ");
	        }
	        builder.delete(builder.length() - 2, builder.length());
	        builder.append(')');
	        return builder.toString();
	    }
}
