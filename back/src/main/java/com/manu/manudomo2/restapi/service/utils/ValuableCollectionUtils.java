package com.manu.manudomo2.restapi.service.utils;

import com.manu.manudomo2.restapi.data.entities.ValuableEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValuableCollectionUtils<T extends ValuableEntity> {

    public void decimateList(List<T> src, double trigger) {
        for (int i = 0; i < src.size(); i++) {
            if (i >= 2) {
                double afterDiff = Math.abs(src.get(i).getValue().doubleValue() - src.get(i - 1).getValue().doubleValue());
                double beforeDiff = Math.abs(src.get(i - 1).getValue().doubleValue() - src.get(i - 2).getValue().doubleValue());

                if (afterDiff <= trigger && beforeDiff <= trigger) {
                    src.remove(i - 1);
                    i--;//On décrémente pour ne pas louper de valeur, étant donné qu'on vient de réduire la taille de 1
                }
            }
        }
    }

    public void moduloReduction(List<T> src, int factor) {
        int counter = 0;
        for (int i = 0; i < src.size(); i++) {
            if (counter % factor != 0) {
                src.remove(i);
                i--;
            }
            counter++;
        }
    }

}
