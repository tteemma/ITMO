package Models.People;

import Interfaces.Stretching;

import java.util.List;
import java.util.Objects;

public class Group<T extends Person> implements Stretching/*implements HasCase*/ {
    private List<T> members;

    public Group(List<T> members){
        setMembers(members);
    }
    public List<T> getMembers(){
        return members;
    }
    public void setMembers(List<T> members){
        this.members = members;
    }
    public void addMember(T member){
        this.members.add(member);
    }
    public boolean contains(T member){
        return members.contains(member);
    }
/*    @Override
    public String dativeCase(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < members.size(); i++){
            if (i == 0) {
                sb.append(members.get(i).dativeCase());
            }else if (i == members.size() - 1){
                sb.append(" и ").append(members.get(i).dativeCase());
            }else {
                sb.append(", ").append(members.get(i).dativeCase());
            }
        }
        return sb.toString();
    }*/


    @Override
    public  String stretch(){
        return "Потянулись";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group<?> group = (Group<?>) o;
        return Objects.equals(members, group.members);
    }

    @Override
    public int hashCode() {
        return Objects.hash(members);
    }
}
