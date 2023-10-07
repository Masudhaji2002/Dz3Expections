public class ConsoleErrorObserver implements ErrorObserver{
    @Override
    public void onError(String errorMessage) {
        System.err.println(errorMessage);
    }
}
