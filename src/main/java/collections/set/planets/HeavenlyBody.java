package collections.set.planets;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(satellites);
    }

    public boolean addMoon(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        System.out.println("obj.getClass() is: " + obj.getClass().getSimpleName());
        System.out.println("this.getClass() is: " + this.getClass().getSimpleName());

        if (obj == null || getClass() != obj.getClass()) return false;
        HeavenlyBody that = (HeavenlyBody) obj;
        return Objects.equals(name, that.name);
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        HeavenlyBody that = (HeavenlyBody) o;
//        return Objects.equals(name, that.name);
//    }

    @Override
    public int hashCode() {
        System.out.println("hashcode called by: " + getName());
        return Objects.hash(name) + 57;
    }
}
