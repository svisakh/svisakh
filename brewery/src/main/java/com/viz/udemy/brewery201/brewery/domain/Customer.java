package com.viz.udemy.brewery201.brewery.domain;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Customer {
	
	@Id
	@GeneratedValue(generator="UUID")
	@GenericGenerator( name ="UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(length=36, columnDefinition="varchar", updatable=false,nullable=false)
	private UUID customerId;
	
	@Version
	private Long version;
	
	@CreationTimestamp
	@Column(updatable=false)
	private Timestamp createdDate;
	
	@UpdateTimestamp
	private Timestamp lastModifiedDate;
	
	private String customerName;
	}
