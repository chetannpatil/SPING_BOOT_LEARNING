package com.chetan.swaggerDemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Product 
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "db generated value")
	private Integer id;
	
	@Version
	@ApiModelProperty(notes = "db generated prudctiid")
	private Integer version;
	
	@ApiModelProperty(notes = "app spec productId ")
	private String productId;
	
	@ApiModelProperty(notes = "product desc")
	private String description;

	private String imageUrl;
	
	
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Integer id, Integer version, String productId, String description) {
		super();
		this.id = id;
		this.version = version;
		this.productId = productId;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", version=" + version + ", productId=" + productId + ", description="
				+ description + "]";
	}
	
	
	
	
}
