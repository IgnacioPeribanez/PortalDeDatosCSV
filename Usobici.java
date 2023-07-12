package portalDeDatosPúblicos;

public class Usobici {
	protected int IDUsuario;
	protected String RetiroDT;
	protected int RetiroEstacion;
	protected String AnclajeDT;
	protected int AnclajeEstacion;
	
	public Usobici(int IDUsuario, String RetiroDT, int RetiroEstacion, String AnclajeDT, int AnclajeEstacion) {
		this.IDUsuario = IDUsuario;
		this.RetiroDT = RetiroDT;
		this.RetiroEstacion = RetiroEstacion;
		this.AnclajeDT = AnclajeDT;
		this.AnclajeEstacion = AnclajeEstacion;
	}

	public int getIDUsuario() {
		return IDUsuario;
	}

	public void setIDUsuario(int iDUsuario) {
		this.IDUsuario = iDUsuario;
	}

	public String getRetiroDT() {
		return RetiroDT;
	}

	public void setRetiroDT(String retiroDT) {
		this.RetiroDT = retiroDT;
	}

	public int getRetiroEstacion() {
		return RetiroEstacion;
	}

	public void setRetiroEstacion(int retiroEstacion) {
		this.RetiroEstacion = retiroEstacion;
	}

	public String getAnclajeDT() {
		return AnclajeDT;
	}

	public void setAnclajeDT(String anclajeDT) {
		this.AnclajeDT = anclajeDT;
	}

	public int getAnclajeEstacion() {
		return AnclajeEstacion;
	}

	public void setAnclajeEstacion(int anclajeEstacion) {
		this.AnclajeEstacion = anclajeEstacion;
	}

	@Override
	public String toString() {
		return "Usobici [IDUsuario=" + IDUsuario + ", RetiroDT=" + RetiroDT + ", RetiroEstacion=" + RetiroEstacion
				+ ", AnclajeDT=" + AnclajeDT + ", AnclajeEstacion=" + AnclajeEstacion + "]";
	}
	
}
