package portalDeDatosPúblicos;

public class UsuarioBizi implements Comparable<UsuarioBizi>{
	protected int IDUsuario;
	protected int Traslados;
	protected int Circular;
	protected int Total;
	
	public UsuarioBizi(int IDUsuario, int Traslados, int Circular, int Total) {
		this.IDUsuario = IDUsuario;
		this.Traslados = Traslados;
		this.Circular = Circular;
		this.Total = Total;
	}

	public UsuarioBizi(int IDUsuario) {
		this.IDUsuario = IDUsuario;
		this.Traslados = 0;
		this.Circular = 0;
		this.Total = 0;
	}

	public int getIDUsuario() {
		return IDUsuario;
	}

	public void setIDUsuario(int iDUsuario) {
		this.IDUsuario = iDUsuario;
	}

	public int getTraslados() {
		return Traslados;
	}

	public void setTraslados(int traslados) {
		this.Traslados = traslados;
	}

	public int getCircular() {
		return Circular;
	}

	public void setCircular(int circular) {
		this.Circular = circular;
	}

	public int getTotal() {
		return Total;
	}

	public void setTotal(int total) {
		this.Total = total;
	}

	@Override
	public String toString() {
		return IDUsuario + "    " + Traslados + "         " + Circular + "        " + Total;
	}
	
	@Override
	public int compareTo(UsuarioBizi u) {
		if (this.Total < u.getTotal()) {
			return 1;
		}else if (this.Total > u.getTotal()) {
			return -1;
		}else {
			return 0;
		}
	}
}
