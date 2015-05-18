package ar.utn.frba.dds.tpAnual2015.java8;

import java.util.Collection;
import java.util.HashSet;
import java.time.LocalDate;

public class Usuario {
	private Sexo sexo;
	private String nombre;
	private LocalDate fechaNacimiento;
	private Complexion complexion;
	private Collection<CondicionPreexistente> condicionesPreexistentes = new HashSet<CondicionPreexistente>();
	private Collection<String> alimentosRechazados = new HashSet<String>();
	private Collection<String> alimentosPreferidos = new HashSet<String>();
	private Recetario recetario;
	private Rutina rutina;
	
	//Constructor
	//XXX: Solo para Pruebas, no me agrada mucho que exista. VER como mejorar
	public Usuario() {
	}

	public Usuario(Sexo sexo, String nombre, LocalDate fechaNacimiento,
			Complexion complexion,
			Collection<CondicionPreexistente> condicionPreexistente,
			Collection<String> alimentosRechazados,
			Collection<String> alimentosPreferidos, Recetario recetario,
			Rutina rutina) {
		//FIXME: (Arreglame), ver si es correcto arraylist o no. Tener en cuenta que no se repitan los alimentos.
		//Bad Smells: long parameter list (lista de parametros larga), VER OTROS.
		super();
		this.sexo = sexo;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.complexion = complexion;
		this.condicionesPreexistentes = condicionPreexistente;
		this.alimentosRechazados = alimentosRechazados;
		this.alimentosPreferidos = alimentosPreferidos;
		this.recetario = recetario;
		this.rutina = rutina;
	}

	//Metodos para establecer contenido y para obtenerlo (Setters y Getters)
	//
	//Metodos para establecer contenido (Setters)
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	public void setRutina(Rutina rutina) {
		this.rutina = rutina;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public void setRecetario(Recetario recetario) {
		this.recetario = recetario;
	}
	
	public void setComplexion(Complexion complexion) {
		this.complexion = complexion;
	}
	
	//Metodos para obtener contenido (Getters)
	
	public String getNombre() {
		return nombre;
	}
	
	public Sexo getSexo() {
		return sexo;
	}

	public Complexion getComplexion() {
		return complexion;
	}
	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public Recetario getRecetario() {
		return recetario;
	}

	public Rutina getRutina() {
		return rutina;
	}
	
	public Collection<String> getAlimentosPreferidos() {
		return alimentosPreferidos;
	}

	public Collection<String> getAlimentosRechazados() {
		return alimentosRechazados;
	}

	public Collection<CondicionPreexistente> getCondPreexistentes() {
		return condicionesPreexistentes;
	}
	
	//Metodos protegidos que asisten la funcionalidad de los metodos publicos de la clase.
	//Se utiliza el modificador de permisos protegido para que los test puedan acceder a los mismos para probarlos 
	
	protected boolean validarNombre(String cadenaPropuestaParaNombre) {
		return cadenaPropuestaParaNombre.length() > 4;
	}

	protected boolean superoLimitacionesDeCondicionesPreexistentes() {
		return (condicionesPreexistentes.stream().allMatch(condicionPreexistente -> 
															condicionPreexistente.superaLimitacionElUsuario(this)));
	}
	
	protected boolean validarFechaDeNacimiento(LocalDate fechaDeNacimientoPropuesta) {
		return fechaDeNacimientoPropuesta.isBefore(LocalDate.now());
	}
	
	protected boolean esNuloAtributo(Object objeto) {
		return objeto.equals(null);
	}
	
	protected boolean validarAtributosObligatorios(){
		//FIXME cambiar por lambda con lista de atributos
		//TODO probar como se comporta isEmpty() con el null 
		return (esNuloAtributo(this.nombre) && this.complexion.validarAtributos()
					&& esNuloAtributo(this.fechaNacimiento) && esNuloAtributo(this.rutina));
	}
	
	protected boolean lograSubsanarCondiciones(){
		return (condicionesPreexistentes.stream().allMatch(c -> c.subsanaCondicionPreexistenteUsuario(this))); 
	}
	
	protected boolean tengoValoresSaludablesDeIMC() {
		//TODO: ver funcionalidad de double un beetwen
		double miIMC = this.complexion.calcularIMC();
		return (18 <= miIMC && miIMC <= 30);
		//return (18 <= this.complexion.calcularIMC() && this.complexion.calcularIMC() <= 30); 
		//Reemplazado para que no realice el calculo 2 veces
	}

	//Metodos publicos funcionalidad de la Clase (interface)	
	
	public void agregarCondicionPreexistente(CondicionPreexistente nueva) {
		condicionesPreexistentes.add(nueva);
	}
	
	public void agregarAlimentoPreferido(String nueva) {
		alimentosPreferidos.add(nueva);
	}
	
	public void quitarCondicionPreexistente(CondicionPreexistente quitar) {
		condicionesPreexistentes.remove(quitar);
	}
	
	public void quitarAlimentoPreferido(String quitar) {
		alimentosPreferidos.remove(quitar);
	}
	
	public boolean soyValido() {
		return (validarAtributosObligatorios() && 
					validarNombre(this.nombre) && 
					superoLimitacionesDeCondicionesPreexistentes() && 
					validarFechaDeNacimiento(this.fechaNacimiento));
	}
	
	public boolean sigueRutinaSaludable(){
		return tengoValoresSaludablesDeIMC() && lograSubsanarCondiciones();
	}
	
	public double obtenerIMC() {
		return this.complexion.calcularIMC();
	}
	
	public void modificarReceta(Receta recetaOriginal, Receta recetaModificada) {
		//FIXME: agregar excepcion de negocio
		if (puedoUtilizarReceta(recetaOriginal)){
			this.recetario.modificarReceta(recetaOriginal, recetaModificada);
		}
	}
	
	public boolean puedoUtilizarReceta(Receta receta) {
		return this.recetario.tengoReceta(receta);
	}
}