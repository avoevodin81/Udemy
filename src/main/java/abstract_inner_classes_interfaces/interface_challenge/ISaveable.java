package abstract_inner_classes_interfaces.interface_challenge;

import java.util.List;

public interface ISaveable {
    List<String> write();
    void read(List<String> savedValues);
}
