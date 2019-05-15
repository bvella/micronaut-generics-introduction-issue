package issue;

import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;
import java.lang.reflect.Method;
import javax.inject.Singleton;

/**
 * Register publisher proxies as spring beans for autowiring.
 *
 * <p>Finds all ServiceSkeleton implementing beans and calls ServiceSupport.getOrCreate() to getOrCreate the proxies.
 */
@Singleton
public final class PublisherIntroduction implements MethodInterceptor<GenericPublisher<?>, Object> {

    @Override
    public Object intercept(final MethodInvocationContext<GenericPublisher<?>, Object> context) {
        final Method method = context.getTargetMethod();
        if (isEqualsMethod(method)) {
            // Only consider equal when proxies are identical.
            return context.getTarget() == context.getParameterValues()[0];

        } else if (isHashCodeMethod(method)) {
            return hashCode();

        } else if (isToStringMethod(method)) {
            return toString();
            
        } else {
            System.out.println(method);
            return null;
        }
    }

    public static boolean isEqualsMethod(final Method method) {
        if ((method == null) || !"equals".equals(method.getName())) {
            return false;
        }
        final Class<?>[] paramTypes = method.getParameterTypes();
        return (paramTypes.length == 1) && (paramTypes[0] == Object.class);
    }

    /**
     * Determine whether the given method is a "hashCode" method.
     */
    public static boolean isHashCodeMethod(final Method method) {
        return (method != null) && "hashCode".equals(method.getName()) && (method.getParameterTypes().length == 0);
    }

    /**
     * Determine whether the given method is a "toString" method.
     */
    public static boolean isToStringMethod(final Method method) {
        return (method != null) && "toString".equals(method.getName()) && (method.getParameterTypes().length == 0);
    }

}