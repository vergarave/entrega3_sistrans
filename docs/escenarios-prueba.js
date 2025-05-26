//Script: Escenarios de Prueba

//RF4
db.medicos.insertOne({
  tipoDocumento: "CC",
  numeroDocumento: "12345678990",
  nombre: "Medico Invalido",
  especialidad: { nombre: "Cardiología" },
  ips: ["900111001"],
  servicios: ["CONSULT-GRAL"]
});

// RF5
db.afiliados.insertOne({
  tipoDocumento: "TI",
  numeroDocumento: "1234567890",
  nombre: "Afiliado inválido",
  fechaNacimiento: ISODate("2010-01-01"),
  direccion: "Calle falsa",
  telefono: "3010000000"
});

// RF6
db.ordenes.insertOne({
  numero: "ORD-INVALIDA",
  fecha: ISODate("2025-06-01T10:00:00Z"),
  estado: "vigente",
  servicio: "CONSULT-GRAL"
});

//RF7
db.agendamientos.insertOne({
  id: "AGENDA-MALA",
  hora: "08:30",
  medico: "RM12345",
  ips: "900111001",
  afiliado: {
    tipoDocumento: "CC",
    numeroDocumento: "123456789"
  }
});



