package br.com.scaap.jpa.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.apache.commons.lang.SystemUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import br.com.scaap.jpa.base.entity.BaseEntity;

public class RecursiveToStringStyle extends ToStringStyle {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private int depth = 0;

	public RecursiveToStringStyle() {
		super();
		this.setUseShortClassName(true);
		this.setUseIdentityHashCode(false);
		this.setContentStart("[");
		this.setFieldSeparator(SystemUtils.LINE_SEPARATOR + "  ");
		this.setFieldSeparatorAtStart(true);
		this.setContentEnd(SystemUtils.LINE_SEPARATOR + "]");
	}

	public RecursiveToStringStyle(int depth) {
		this();
		this.depth = depth;
		this.setFieldSeparator(getFieldSeparator() + getSpacing());
		this.setContentEnd(SystemUtils.LINE_SEPARATOR + getSpacing() + "]");
	}

	@Override
	protected void appendDetail(StringBuffer buffer, String fieldName, Object value) {
		if (value instanceof Date) {
			value = new SimpleDateFormat("dd/MM/yyyy").format(value);
		}
		if (value instanceof Double) {
			value = new DecimalFormat("#,##0.00").format(value);
		}
		if (value instanceof BaseEntity) {
			value = value.getClass().getSimpleName() + "#" + ((BaseEntity) value).getId();
		}
		buffer.append(value);
	}

	@Override
	@SuppressWarnings("rawtypes")
	protected void appendDetail(StringBuffer buffer, String fieldName, Collection value) {
		if (value.size() > 0) {
			buffer.append("<" + value.size() + ">[");
			depth++;
			for (Object obj : value) {
				buffer.append(getFieldSeparator() + getSpacing());
				buffer.append(ToStringBuilder.reflectionToString(obj, new RecursiveToStringStyle(depth + 1)));
			}
			buffer.append(SystemUtils.LINE_SEPARATOR + getSpacing() + "]");
			depth--;
		} else {
			buffer.append("<empty>");
		}
	}

	private String getSpacing() {
		String output = "";
		for (int i = 0; i < depth; i++) {
			output = output + ("  ");
		}
		return output;
	}

}