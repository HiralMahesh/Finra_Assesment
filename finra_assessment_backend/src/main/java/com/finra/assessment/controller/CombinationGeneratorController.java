package com.finra.assessment.controller;

import com.finra.assessment.exception.WrongLengthException;
import com.finra.assessment.model.CombinationDTO;
import com.finra.assessment.service.MakeCombinations;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CombinationGeneratorController {

    MakeCombinations makeCombinations;

    @Autowired
    public CombinationGeneratorController(MakeCombinations makeCombinations){
        this.makeCombinations=makeCombinations;
    }

    @ApiOperation(value = "Returns alpha-numeric combination of given number")
    @ApiResponses(value = {
            @ApiResponse(code =200,message = "Success"),
            @ApiResponse(code =417,message = "Length of Number is not correct must be 7 or 10 digit")
    })
    @GetMapping(value = "/{number}", produces = "application/json")
    public CombinationDTO getCombinations(@PathVariable(value = "number") String number, @RequestParam(name = "page", defaultValue="1") int page){
        if (number.length() == 7 || number.length() == 10)
        {
            CombinationDTO res=makeCombinations.generateCombinations(number, page);
            return res;
        }
        else
        {
            throw new WrongLengthException();
        }


    }
}