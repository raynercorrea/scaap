package br.com.scaap.jpa.base.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.log4j.Logger;

import br.com.scaap.jpa.util.RecursiveToStringStyle;

@MappedSuperclass
public abstract class BaseEntity implements IBaseEntity, Cloneable {

	private static final long serialVersionUID = 1L;
	
	protected static final Logger log = Logger.getRootLogger();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isPersistent() {
		return (id != null);
	}
	
	public boolean equalsIgnoreId(IBaseEntity obj) {
		return this.toString().equals(obj.toString());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (this.getClass() != obj.getClass()) {
			return false;
		}

		IBaseEntity that = (IBaseEntity) obj;
		return (this.isPersistent() && that.isPersistent())
					? ObjectUtils.equals(this.getId(), that.getId())
							: equalsIgnoreId(that); 
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, new RecursiveToStringStyle());
	}

	@Override
	public int hashCode() {
		if (this.id == null) {
			return HashCodeBuilder.reflectionHashCode(this);
		}
		return id.hashCode();
	}
	
}