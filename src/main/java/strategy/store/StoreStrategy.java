package strategy.store;

public class StoreStrategy {

    private IStore store;

    public StoreStrategy(){}

    public StoreStrategy(IStore store){
        this.store = store;
    }

    public void upNewClothes(String key){
        IStore store = StoreFactory.getInstance().getStore(key);
        store.upShelf();
    }
}
