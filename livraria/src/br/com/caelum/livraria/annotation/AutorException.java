package br.com.caelum.livraria.annotation;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class AutorException extends Exception {

}
