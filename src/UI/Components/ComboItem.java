package UI.Components;

public final class ComboItem {
    private String Key;
    private String Value;

    public ComboItem(String key, String value)
    {
        Key = key;
        Value = value;
    }

    @Override
    public String toString()
    {
        return Key;
    }

    public String getKey()
    {
        return Key;
    }

    public String getValue()
    {
        return Value;
    }

}
