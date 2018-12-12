/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
