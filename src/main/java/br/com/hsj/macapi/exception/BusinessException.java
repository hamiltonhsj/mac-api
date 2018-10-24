package br.com.hsj.macapi.exception;

public class BusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusinessException(String _mensagem) {
		super(_mensagem);
	}
	
	public BusinessException(String _mensagem, Throwable _e) {
		super(_mensagem, _e);
	}
}
