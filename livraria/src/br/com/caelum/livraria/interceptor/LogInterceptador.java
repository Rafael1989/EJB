package br.com.caelum.livraria.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptador {
	
	@AroundInvoke
	public Object intercepta(InvocationContext context) throws Exception {
		long inicio = System.currentTimeMillis();
		Object object = context.proceed();
		long fim = System.currentTimeMillis();
		System.out.println(context.getTarget().getClass().getSimpleName()+":"+context.getMethod().getName()+":"+(fim-inicio));
		return object;
	}

}
