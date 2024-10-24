package com.tka.OrganizationalWorkFlow.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Country {

@Id   //jakarta.persistence
@GeneratedValue(strategy = GenerationType.IDENTITY) //jakarta.persistence
private int cid;
private String cname;

public Country(String cname) {
	super();
	this.cname = cname;
}
public Country() {
	super();
	// TODO Auto-generated constructor stub
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
@Override
public String toString() {
	return "Company [cid=" + cid + ", cname=" + cname + "]";
}


}
