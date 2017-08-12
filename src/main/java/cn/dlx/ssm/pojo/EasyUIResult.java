package cn.dlx.ssm.pojo;

import java.util.List;

public class EasyUIResult {
	private Long total;
	private List<?> rows;

	public Long getTotal() {
		return total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
