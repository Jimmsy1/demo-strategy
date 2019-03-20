package strategy.store;

import java.util.HashMap;
import java.util.Map;

public class StoreFactory {

    private StoreFactory (){
        if(StoreHelp.FACTORY != null){
            throw new NullPointerException("不允许反射创建");
        }
    }

    private static StoreFactory storeFactory = null;

    public static StoreFactory getInstance(){
        storeFactory = StoreHelp.FACTORY;
        return storeFactory;
    }

    private static class StoreHelp{
        public static final StoreFactory FACTORY = new StoreFactory();
    }

    public Object readResolve(){
        return StoreHelp.FACTORY;
    }

    private static Map<String , IStore> storeMap = new HashMap<String, IStore>();

    static {
        storeMap.put(StoreType.STRING , new SpringStore());
        storeMap.put(StoreType.SUMMER , new SummerStore());
        storeMap.put(StoreType.WINTER , new WinterStore());
        storeMap.put(StoreType.AUTUMN , new AutumnStore());
    }

    public IStore getStore(String key){
        IStore store = null;
        if(storeMap.containsKey(key)){
            store = storeMap.get(key);
        }else{
            store = storeMap.get(key);
        }
        return store;
    }

    class StoreType{
        public static final String STRING = "SPRING";
        public static final String SUMMER = "SUMMER";
        public static final String WINTER = "WINTER";
        public static final String AUTUMN = "AUTUMN";
    }


}
