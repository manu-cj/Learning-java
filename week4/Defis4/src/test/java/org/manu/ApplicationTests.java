package org.manu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.manu.models.Doctor;
import org.manu.repositories.DoctorRepository;
import org.manu.services.DoctorService;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTests {

  private DoctorRepository doctorRepository;
  private DoctorService doctorService;

  @BeforeEach
  void setUp() {
    doctorRepository = mock(DoctorRepository.class);
    doctorService = new DoctorService(doctorRepository);

    outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
  }

  @Test
  void testRegisterDoctor() {
    // Given
    String name = "John Doe";
    String role = "pédiatre";
    Doctor expectedDoctor = new Doctor("DR. John Doe", role);

    // When
    doctorService.registerDoctor(name, role);

    // Then
    verify(doctorRepository).addDoctor(expectedDoctor);
  }


  private final PrintStream originalOut = System.out;
  private ByteArrayOutputStream outContent;



  @AfterEach
  void tearDown() {
    System.setOut(originalOut);
  }

  @Test
  void testGenerateReportWhenNoDoctors() {
    when(doctorRepository.getAllDoctor()).thenReturn(List.of());

    doctorService.generateReport();

    String expected = """
                
                --- Doctor List report ---
                No doctor recorded yet
                ---------------------------
                """;

    assertEquals(expected.trim(), outContent.toString().trim());
  }

  @Test
  void testGenerateReportWithDoctors() {
    List<Doctor> doctors = List.of(
            new Doctor("DR. House", "diagnosticien"),
            new Doctor("DR. Grey", "chirurgien")
    );
    when(doctorRepository.getAllDoctor()).thenReturn(doctors);

    doctorService.generateReport();

    String expected = """
                
                --- Doctor List report ---
                DR. House
                Role : diagnosticien
                DR. Grey
                Role : chirurgien
                ---------------------------
                """;

    assertEquals(expected.trim(), outContent.toString().trim());
  }

  @Test
  void testGetDoctorByRole() {
    List<Doctor> doctors = List.of(
            new Doctor("DR. House", "diagnosticien"),
            new Doctor("DR. Grey", "diagnosticien")
    );
    when(doctorRepository.getAllDoctorsByRole("diagnosticien")).thenReturn(doctors);

    doctorService.getDoctorByRole("diagnosticien");

    String expected = """
    --- Doctor (diagnosticien) List report ---
    DR. House
    Role : diagnosticien
    DR. Grey
    Role : diagnosticien
    ---------------------------
    
    Total doctors with role (diagnosticien) : 2
    """;

    assertEquals(expected.trim(), outContent.toString().trim());
  }


}

