package com.example.server.repository;


import com.example.server.error.ObjectNotFound;
import com.example.server.model.Sight;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class SightRepository {

    private List<Sight> sights = new ArrayList<>();

    public List<Sight> listSight(){
        return sights;
    }

    public Sight getSightById(Long id){
        for(Sight s:sights){
            if(Objects.equals(s.getId(),id)) return s;
        }
        throw new ObjectNotFound("Sight with id: "+id+" wasnt found");
    }

    public void addSight(Sight sight){
        sights.add(sight);
    }

    public Sight updateSight(Sight sight){
        for(Sight s:sights){
            if(Objects.equals(s.getId(), sight.getId())){
                s.setId(sight.getId());
                s.setName(sight.getName());
                return s;
            }
        }
        throw new ObjectNotFound("Sight with id: "+sight.getId()+" wasnt found");
    }

    public void delete(Long id){
        Sight sight=null;
        for(Sight s:sights){
            if(Objects.equals(s.getId(), id)){
               sight=s;
            }
        }
        if(sight!=null){
            sights.remove(sight);
        }
        else  throw new ObjectNotFound("Sight with id: "+id+" wasnt found");
    }
}
