package item10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Broken - violates symmetry
public final class CaseInsensitiveString {

    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    // Broken - violates symmetry
    @Override
    public boolean equals(Object o) {
        if(o instanceof  CaseInsensitiveString) {
            return s.equalsIgnoreCase(
                    ((CaseInsensitiveString) o).s
            );
        }
        if(o instanceof String)
            return s.equalsIgnoreCase((String) o);
        return false;
    }

    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("TEST CASe");
        String s = "TEST CASE";

        List<CaseInsensitiveString> list = new ArrayList<CaseInsensitiveString>();
        list.add(cis);
    }

}
