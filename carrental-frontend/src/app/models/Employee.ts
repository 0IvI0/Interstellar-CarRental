import { User } from "./User";

export interface Employee extends User {

/*     username: string;
    password: string;
    firstName: string;
    lastName: string;
    userRole: string;
    birthDate: number; //LocalDate
    emailAddress: string;
    phoneNumber: string;
    address: string;
    creditCardNumber: string;
    //List<Invoice> invoiceList: */

    employeeNr: string;

}