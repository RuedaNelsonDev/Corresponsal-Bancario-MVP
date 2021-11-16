package com.example.corresponsalwpossmvp.tools;

public class Constant {
    public  static  final String DATABASE_NAME = "wpossBank.db";
    public static final int DATABASE_VERSION = 1;

    public  static  final  String TABLE_ADMIN = "admin";
    public  static  final  String COLUMN_ADMIN_ID = "admin_id";
    public  static  final  String COLUMN_ADMIN_MAIL = "admin_mail";
    public  static  final  String COLUMN_ADMIN_PASSWORD = "admin_password";


    public  static  final  String TABLE_CORRESPONDENT = "corresponsal";
    public  static  final  String COLUMN_CORRESPONDENT_ID = "corresponsal_id";
    public  static  final  String COLUMN_CORRESPONDENT_ACCOUNT = "corresponsal_cuenta";
    public  static  final  String COLUMN_CORRESPONDENT_BALANCE = "corresponsal_saldo";
    public  static  final  String COLUMN_CORRESPONDENT_NAME = "corresponsal_nombre";
    public  static  final  String COLUMN_CORRESPONDENT_LAST_NAME = "corresponsal_apellido";
    public  static  final  String COLUMN_CORRESPONDENT_IDENTIFICATION = "corresponsal_identificacion";
    public  static  final  String COLUMN_CORRESPONDENT_MAIL = "corresponsal_mail";
    public  static  final  String COLUMN_CORRESPONDENT_PASSWORD = "corresponsal_password";
    public  static  final  String COLUMN_CORRESPONDENT_PHONE = "corresponsal_telefono";
    public  static  final  String COLUMN_CORRESPONDENT_ADDRESS = "corresponsal_direccion";
    public  static  final  String COLUMN_CORRESPONDENT_STATUS = "corresponsal_estado";

    public static final String TABLE_CLIENT = "cliente";
    public static final String COLUMN_CLIENT_ID = "cliente_id";
    public static final String COLUMN_CLIENT_BALANCE = "cliente_saldo";
    public static final String COLUMN_CLIENT_IDENTIFICATION = "cliente_identificacion";
    public static final String COLUMN_CLIENT_NAME = "cliente_nombre";
    public static final String COLUMNA_CLIENT_LAST_NAME = "cliente_apellido";
    public static final String COLUMN_CLIENT_CARD = "cliente_tarjeta";
    public static final String COLUMN_CLIENT_CARD_TYPE = "cliente_tarjeta_tipo";
    public static final String COLUMN_CLIENT_CARD_CVV = "cliente_tarjeta_cvv";
    public static final String COLUMN_CLIENT_CARD_VEN = "cliente_tarjeta_ven";
    public static final String COLUMN_CLIENT_PIN = "cliente_pin";
    public static final String COLUMN_CLIENT_STATUS = "cliente_estado";

    public static final String TABLE_TRANSACTION = "transaccion";
    public static final String COLUMN_TRANSACTION_ID = "transaccion_id";
    public static final String COLUMN_TRANSACTION_DATE = "transaccion_fecha";
    public static final String COLUMN_TRANSACTION_HOUR = "transaccion_hora";
    public static final String COLUMN_TRANSACTION_TIPE = "transaccion_tipo";
    public static final String COLUMN_TRANSACTION_TOTAL_VALUE = "transaccion_valor_total";
    public static final String COLUMN_TRANSACTION_VALUE = "transaccion_valor";
    public static final String COLUMN_TRANSACTION_COMISION = "transaccion_comision";
    public static final String COLUMN_TRANSACTION_ACCOUNT_CORRESPONAL = "transaccion_cuenta_corresponsal";
    public static final String COLUMN_TRANSACTION_SENDER = "transaccion_identifcacion_remitente";
    public static final String COLUMN_TRANSACTION_RECEIVER = "transaccion_identificacion_receptor";
    public static final String COLUMN_TRANSACTION_CARD = "transaccion_tarjeta";
    public static final String COLUMN_TRANSACTION_QUOTAS = "transaccion_cuotas";

    public static final String REGISTER_CORRESPONDENT = "Registrar Corresponsal";
    public static final String REGISTER_CORRESPONDENT_IMG = "https://cdn-icons-png.flaticon.com/512/2910/2910768.png";

    public static final String REGISTER_CLIENT = "Registrar Cliente";
    public static final String REGISTER_CLIENT_IMG = "https://cdn-icons-png.flaticon.com/512/3456/3456420.png";

    public static final String SHOW_CORRESPONDENT = " Mostrar Corresponsal ";
    public static final String SHOW_CORRESPONDENT_IMG = "https://cdn-icons-png.flaticon.com/512/2910/2910808.png";

    public static final String SHOW_CLIENT = "Mostrar Cliente";
    public static final String SHOW_CLIENT_IMG = "https://cdn-icons-png.flaticon.com/512/2910/2910787.png";
}
