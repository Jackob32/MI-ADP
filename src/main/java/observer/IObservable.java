/*
abstrakce observable
 */
package observer;

/**
 *
 * @author Jakub
 */
public interface IObservable {

    void attachObserver(IObserver obs);

    void detachObserver(IObserver obs);

    void notifyMyObservers();

}
