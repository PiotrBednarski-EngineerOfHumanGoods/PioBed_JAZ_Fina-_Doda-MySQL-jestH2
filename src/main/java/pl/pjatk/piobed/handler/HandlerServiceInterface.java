package pl.pjatk.piobed.handler;

/**
 * Wspólny kontrakt dla serwisów zwracających wiadomość zależną od środowiska
 * (DEV / QA / STAGING / PROD).
 *
 * Każda implementacja zwraca:
 *   - getEnvironment() - klucz po którym FacadeService wybiera daną implementację,
 *   - getMessage()     - tekst odpowiedzi specyficzny dla środowiska.
 *
 * Wykorzystanie tego interfejsu w FacadeService to przykład wzorca Strategy +
 * mechanizmu wstrzykiwania kolekcji beanów (List<HandlerServiceInterface>).
 */
public interface HandlerServiceInterface {

    String getEnvironment();

    String getMessage();
}
