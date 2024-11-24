package p3.project.projectogestionnomina;

import p3.project.projectogestionnomina.Empleados.CuentaBancaria;

import java.util.Calendar;
import java.util.Date;

public final class CONST {
    public static final double PI = 3.14;
    public static final String BD_Empleados = "BD_Empleados.JSON";
    public static final String BD_CuentasBancarias = "BD_CuentasBancarias.JSON";
    public static final CuentaBancaria CUENTA_ORIGEN = new CuentaBancaria("Cuenta Corriente", "1234567890", "DOP", "40213918564");
    public static final String EXPORT_BANRESERVAS = "nomina_banreservas.txt";
    public static final String EXPORT_BHD = "nomina_bhd.txt";
    public static final String EXPORT_POPULAR = "nomina_popular.txt";
    public static final float ARS = 3.04f;
    public static final float AFP = 2.87f;
    public static final String COMPANY_ID = "40213918564";
    public static final String EFFECTIVE_DATE = "20241124";
    public static final String COMPANY_NAME = "SuperMercado La Suertuda";
    public static final int HEADER_SEQUENCE = 1;
    public static final String EMAIL = "lasuertuda@market.net";
    public static final String SEND_DATE = "20241125";
    public static final String SEND_TIME = "2305" ;



    public static final String[] FUNNY_NAMES = new String[]{
            "Esthiber", "Cristofebril", "Yasnovia", "Fulanito", "Menganito",
            "Perencejo", "Agapito", "Pancracio", "Anacleto", "Eustaquio",
            "Hermelinda", "Delfin", "Torcuato", "Petronilo", "Ludovico",
            "Rosendo", "Melquiades", "Fulgencio", "Crispín", "Tranquilino",
            "Genoveva", "Remigia", "Cirilo", "Clodomiro", "Bartolo",
            "Artemisa", "Jeremías", "Floripondio", "Jacinta", "Leoncio",
            "Brígida", "Clemencio", "Gumersinda", "Ceferino", "Dolores",
            "Estanislao", "Maximino", "Rufina", "Socorro", "Pánfilo",
            "Teodoro", "Casimiro", "Silvina", "Bonifacio", "Cornelio",
            "Esperanza", "Hipólito", "Joaquina", "Venancio", "Benedicto"
    };

    public static final String[] FUNNY_LASTNAMES = new String[]{
            "Valentín", "Pérez", "López", "Rodríguez", "González",
            "Martínez", "Fernández", "Gutiérrez", "Hernández", "Ramírez",
            "Díaz", "Moreno", "Alvarez", "Jiménez", "Vega",
            "Torres", "Castillo", "Ortiz", "Vázquez", "Mendoza",
            "Guerrero", "Cabrera", "Campos", "Espinosa", "Maldonado",
            "Navarro", "Romero", "Santos", "Blanco", "Escobar",
            "Iglesias", "Serrano", "Muñoz", "Rubio", "Domínguez",
            "Rivera", "Vargas", "Nieves", "Bravo", "Ríos",
            "Reyes", "Figueroa", "Cardenas", "Salazar", "Ojeda",
            "Cano", "Suárez", "Peña", "Cruz", "Delgado"
    };

    public static final int[] FUNNY_AGES = new int[]{
            20, 25, 30, 35, 22, 28, 24, 26, 32, 40,
            45, 19, 21, 23, 27, 29, 31, 33, 36, 38,
            41, 44, 46, 50, 60, 18, 34, 39, 43, 48,
            55, 58, 62, 70, 80, 17, 22, 30, 37, 42,
            49, 53, 56, 59, 61, 65, 68, 72, 75, 77
    };

    public static final String[] FUNNY_IDS = new String[]{
            "40213918564", "12345678901", "98765432109", "45612378912", "85296374108",
            "15935748620", "35795165408", "74185296310", "95175385204", "65412378956",
            "32165498703", "11122233344", "22233344424", "55566677788", "66677788899",
            "77788899900", "88899911122", "99911122233", "11223344556", "22334455667",
            "33445566778", "44556677889", "55667788990", "66778899001", "77889900112",
            "88990011223", "99001122334", "10111213141", "21222324252", "32333435363",
            "43444546474", "54555657585", "65666768696", "76777878898", "87888989900",
            "98990001123", "10102030405", "11112131415", "12132333435", "13142434445",
            "14152535455", "15162636465", "16172737475"
    };

    public static final String[] FUNNY_PHONENUMBERS = new String[]{
            "8298024084", "8091234567", "8299876543", "8096543210", "8497539514",
            "8491593578", "8293571598", "8099517532", "8497418526", "8291237894",
            "8493692581", "8092583697", "8294567891", "8496789123", "8097894561",
            "8291472583", "8498529637", "8099638524", "8293216547", "8499873215",
            "8097891234", "8296549873", "8494561238", "8098527416", "8297531592",
            "8493579518", "8091478529", "8293697415", "8492581476", "8099513576",
            "8297534862", "8491592468", "8097531594", "8292587531", "8496541237",
            "8091236547", "8299874563", "8493217895", "8094569872", "8297896541",
            "8499631475", "8093692584", "8298527419", "8497891238", "8096547891",
            "8299513574", "8497539516", "8092589634", "8291234567", "8497418523"
    };

    public static final String[] FUNNY_ROLES = new String[]{
            "Ingeniero de Desilusiones", "Chef de Ensueños", "Administrador de Caos",
            "Contador de Estrellas", "Especialista en Problemas", "Diseñador de Tragedias",
            "Vendedor de Milagros", "Analista de Curiosidades", "Piloto de Aventuras",
            "Maestro del Disimulo", "Arquitecto de Sueños Rotos", "Gerente de Imposibles",
            "Técnico en Lunas Llena", "Encargado de Fantasías", "Supervisor de Lo Inesperado",
            "Detective de Dudas", "Cazador de Secretos", "Jardinero de Nubes",
            "Asistente de Desperfectos", "Coordinador de Eventos Extraños",
            "Consultor de Misterios", "Mecánico de Soluciones", "Editor de Realidades",
            "Programador de Recuerdos", "Piloto de Sueños", "Instructor de Frustraciones",
            "Vigilante de Ocasos", "Manejador de Desafíos", "Embajador de Dificultades",
            "Especialista en Desastres", "Fabricante de Esperanzas", "Gerente de Contratiempos",
            "Investigador de Enigmas", "Técnico en Dudas", "Constructor de Problemas",
            "Director de Preocupaciones", "Supervisor de Sombras", "Decorador de Atardeceres",
            "Desarrollador de Retos", "Especialista en Complicaciones", "Diseñador de Problemas",
            "Profesor de Problemas", "Ingeniero de Soluciones Inexistentes",
            "Consultor de Confusión", "Guía de Laberintos", "Guardián del Imposible",
            "Encargado de Desilusiones", "Jefe de Pretextos", "Explorador de Límites",
            "Administrador de Complicaciones"
    };

    public static final Date[] FUNNY_JOINDATES = new Date[]{
            new Date(2000 - 1900, 9, 11), new Date(1999 - 1900, 4, 23),
            new Date(1998 - 1900, 1, 15), new Date(2001 - 1900, 6, 17),
            new Date(2005 - 1900, 3, 8), new Date(2010 - 1900, 11, 19),
            new Date(1996 - 1900, 5, 20), new Date(2003 - 1900, 7, 12),
            new Date(2002 - 1900, 2, 4), new Date(1997 - 1900, 8, 14),
            new Date(2012 - 1900, 10, 30), new Date(1993 - 1900, 11, 25),
            new Date(1994 - 1900, 0, 3), new Date(2008 - 1900, 9, 9),
            new Date(2007 - 1900, 7, 7), new Date(2011 - 1900, 6, 28),
            new Date(1995 - 1900, 4, 16), new Date(2004 - 1900, 3, 22),
            new Date(2014 - 1900, 1, 13), new Date(1998 - 1900, 5, 11),
            new Date(2006 - 1900, 7, 18), new Date(1991 - 1900, 2, 5),
            new Date(2013 - 1900, 0, 31), new Date(2009 - 1900, 10, 27),
            new Date(1992 - 1900, 8, 21), new Date(1999 - 1900, 3, 29),
            new Date(2000 - 1900, 4, 24), new Date(2015 - 1900, 6, 3),
            new Date(1990 - 1900, 9, 20), new Date(2001 - 1900, 12, 1),
            new Date(2003 - 1900, 11, 15), new Date(2002 - 1900, 7, 6),
            new Date(2016 - 1900, 8, 2), new Date(1993 - 1900, 5, 9),
            new Date(1997 - 1900, 3, 14), new Date(2008 - 1900, 10, 22),
            new Date(2019 - 1900, 1, 28), new Date(2020 - 1900, 7, 10),
            new Date(2005 - 1900, 0, 18), new Date(1994 - 1900, 2, 7),
            new Date(1995 - 1900, 6, 5), new Date(2011 - 1900, 8, 16),
            new Date(1996 - 1900, 4, 30), new Date(2010 - 1900, 11, 12),
            new Date(2018 - 1900, 9, 3), new Date(2017 - 1900, 2, 19),
            new Date(2015 - 1900, 6, 23), new Date(2006 - 1900, 11, 31),
            new Date(2014 - 1900, 8, 8), new Date(2007 - 1900, 5, 25)
    };

    public static final String[] FUNNY_EMAILS = new String[]{
            "cutekitties@bread.com", "cheesepizza@nomnom.com", "funnycat@laugh.com",
            "oopsydaisy@whoops.com", "seriousbusiness@lol.com", "notarobot@human.net",
            "sillygoose@quack.com", "bananapancakes@yum.net", "rainbowfish@ocean.com",
            "talkingturtle@slowly.com", "cosmiccowboy@stars.com", "friendlyghost@boo.net",
            "laughinglion@roar.com", "dancingdino@rawr.net", "happyhamster@spin.com",
            "fizzyfox@spark.com", "speedykoala@zoom.com", "bouncingbear@hop.net",
            "wittywalrus@arctic.com", "jellybean@gummy.com", "smartpenguin@chill.net",
            "politeporcupine@spike.com", "funkyfrog@ribbit.net", "sleepysloth@yawn.com",
            "nerdynarwhal@ocean.net", "funnyowl@hoot.com", "coolcat@meow.net",
            "gigglesquirrel@nuts.com", "happyturtle@shell.net", "goofypanda@bamboo.com",
            "smartyfox@clever.net", "chillzebra@stripes.com", "bravebee@buzz.net",
            "jumpyjackal@desert.com", "silentswan@lake.com", "nobledeer@forest.net",
            "wittywolf@howl.com", "quirkyquail@feathers.net", "brightbadger@dig.com",
            "loopylemur@tree.net", "energeticeel@shock.com", "chubbychipmunk@nuts.net",
            "cozystarfish@ocean.com", "noisygoose@honkhonk.net", "splashydolphin@wave.com",
            "happyhedgehog@cute.net", "gigglinggecko@climb.com", "cuddlykoala@hug.net",
            "perkyparrot@tweet.com", "grumpygoat@baaa.net"
    };

    public static final CuentaBancaria[] FUNNY_BANKACCOUNTS = new CuentaBancaria[]{
            new CuentaBancaria("Cuenta Ahorros", "1234567890", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "2345678901", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "3456789012", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "4567890123", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "5678901234", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "6789012345", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "7890123456", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "8901234567", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "9012345678", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "0123456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "1023456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "1123456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "1223456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "1323456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "1423456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "1523456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "1623456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "1723456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "1823456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "1923456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "2023456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "2123456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "2223456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "2323456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "2423456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "2523456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "2623456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "2723456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "2823456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "2923456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "3023456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "3123456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "3223456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "3323456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "3423456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "3523456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "3623456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "3723456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "3823456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "3923456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "4023456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "4123456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "4223456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "4323456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "4423456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "4523456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "4623456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "4723456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "4823456789", "DOP", ""),
            new CuentaBancaria("Cuenta Ahorros", "4923456789", "DOP", "")
    };



}
