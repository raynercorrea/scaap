package br.com.scaap.jpa.base.entity;

import java.io.Serializable;

public interface IBaseEntity extends Serializable {

	public Integer getId();

	public void setId(Integer id);

	public boolean isPersistent();
	
	public boolean equalsIgnoreId(IBaseEntity obj);

}
