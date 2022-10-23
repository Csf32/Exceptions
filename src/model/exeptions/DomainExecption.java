package model.exeptions;

public class DomainExecption extends Exception {
		//RuntimeException é usado quando não é obrigado a tratar 
		//ao colocar try catch no programa principal
		//Porém se colocar a exceção personalizada como subclasse de Exception, o compilador obriga a tratar

	private static final long serialVersionUID = 1L; 
	
	public DomainExecption(String msg) {
//Como é uma subclasse de Program é preciso tmb permitir instanciar a exceção passando um novo argumento 
		super(msg);
	}
	
}
