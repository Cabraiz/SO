package Beans;

/**
 * @author Mateus
 */
public class Processo {

	public int ID;
	public int exe;
	/**
	 * (4/20)
	 */
	public java.sql.Timestamp deadline;
	/**
	 * (4/20)
	 */
	public long createTime;
	public int prior;
	/**
	 * (0/3)
	 */
	java.util.Random rd = new Random();

	public int getID() {
		return this.ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public java.sql.Timestamp getDeadline() {
		return this.deadline;
	}

	public void setDeadline(java.sql.Timestamp deadline) {
		this.deadline = deadline;
	}

	public java.util.Random getRd() {
		return this.rd;
	}

	public void setRd(java.util.Random rd) {
		this.rd = rd;
	}

	public Processo() {
		// TODO - implement Processo.Processo
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 * @param execucao
	 * @param deadline
	 * @param prioridade
	 * @param createTime
	 */
	public Processo(int ID, int execucao, java.sql.Timestamp deadline, int prioridade, long createTime) {
		// TODO - implement Processo.Processo
		throw new UnsupportedOperationException();
	}

	public int getExecucao() {
		// TODO - implement Processo.getExecucao
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param execucao
	 */
	public void setExecucao(int execucao) {
		// TODO - implement Processo.setExecucao
		throw new UnsupportedOperationException();
	}

	public int getPrioridade() {
		// TODO - implement Processo.getPrioridade
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param prioridade
	 */
	public void setPrioridade(int prioridade) {
		// TODO - implement Processo.setPrioridade
		throw new UnsupportedOperationException();
	}

}