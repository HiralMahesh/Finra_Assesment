package com.finra.assessment.service;


import java.util.List;
import java.util.HashMap;
import com.finra.assessment.exception.InvalidInputException;
import com.finra.assessment.model.CombinationDTO;

import org.springframework.stereotype.Service;
import sun.awt.geom.AreaOp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

@Service
public class MakeCombinations {
    public static CombinationDTO generateCombinations(String digits, int page) {
            HashMap<Character, String> map = new HashMap<>();
            map.put('0',"#");
            map.put('1',"@");
            map.put('2', "ABC");
            map.put('3', "DEF");
            map.put('4', "GHI");
            map.put('5', "JKL");
            map.put('6', "MNO");
            map.put('7', "PQRS");
            map.put('8', "TUV");
            map.put('9', "WXYZ");
            String option = "";
            ArrayList<String> res = new ArrayList();
            List<String> l = new ArrayList<>();
            l.add("");

            for (int i = 0; i < digits.length(); i++) {
                ArrayList<String> temp = new ArrayList<>();
                option = map.get(digits.charAt(i));
                for (int j = 0; j < l.size(); j++) {
                    for (int p = 0; p < option.length(); p++) {
                        String abc = new StringBuilder(l.get(j)).append(option.charAt(p)).toString();
                        if (abc.length() > 0)
                        {
                            abc = abc.replaceAll("@","1");
                            abc = abc.replaceAll("#","0");
                            temp.add(abc);
                            abc = abc + digits.substring( 0+abc.length(),digits.length() );
                            abc = abc.replaceAll("@","1");
                            abc = abc.replaceAll("#","0");

                            res.add(abc);
                        }
                    }
                }
                l.clear();
                l.addAll(temp);
            }
        System.out.println(res);
            ArrayList<String> result = new ArrayList();
            int offset = (page - 1)*20;
            int limit = offset + 20;
            for(int i = offset; i<limit; i++) {
                if (i >= res.size()) {
                    break;
                }
                result.add(res.get(i));
            }
            CombinationDTO combinationDTO = new CombinationDTO(result,res.size());

            return combinationDTO;
        }


}


