import java.lang.reflect.Method;

public aspect SaldoReducido {

	pointcut validarSaldoReducido() : call (* ejemplo.cajero.modelo.Cuenta.retirar(long));

	before() throws Exception : validarSaldoReducido() {

		long valorAretirar = (long) thisJoinPoint.getArgs()[0];

		Object targetObject = thisJoinPoint.getTarget();
		Method m = targetObject.getClass().getMethod("getSaldo");
		long saldo = (long) m.invoke(targetObject);

		long diferencia = saldo - valorAretirar;
//			System.out.println("Diferencia: " + diferencia);
		if ((diferencia) < 200000) {
			throw new Exception("Saldo Reducido. no puede ser menor a $200.000");
		}

	}
}