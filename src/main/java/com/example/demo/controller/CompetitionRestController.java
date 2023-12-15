package com.example.demo.controller;

import com.example.demo.converter.CompetitionConverter;
import com.example.demo.DTO.CompetitionDTO;
import com.example.demo.entity.Competition;
import com.example.demo.service.CompetitionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class CompetitionRestController {

    @Autowired
    CompetitionService competitionService;

    @PostMapping("/competitions")
    public ResponseEntity<?> saveCompetition(@RequestBody CompetitionDTO competitionDTO) {
        Competition competition = CompetitionConverter.convertToEntity(competitionDTO);
        Competition addedCompetition = competitionService.saveCompetition(competition);
        CompetitionDTO addedCompetitionDTO = CompetitionConverter.convertToDTO(addedCompetition);
        return new ResponseEntity<>(addedCompetitionDTO, HttpStatus.OK);
    }

    @GetMapping("/competitions")
    public ResponseEntity<?> getCompetitions() {
            List<Competition> competitions =competitionService.getCompetitions();
            List<CompetitionDTO> competitionDTOList = CompetitionConverter.convertToDTOList(competitions);
            return new ResponseEntity<>(competitionDTOList, HttpStatus.OK);
    }










    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<List<String>> handleValidationException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<String> validationErrors = new ArrayList<>();
        bindingResult.getFieldErrors().forEach(error ->
                validationErrors.add(error.getField() + ": " + error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(validationErrors);
    }



}
