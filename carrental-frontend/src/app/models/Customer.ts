export class Customer {

    username: string;
    password: string;
    firstName: string;
    lastName: string;
    userRole: string;
    //birthDate: number; //LocalDate
    emailAddress: string;
    phoneNumber: string;
    address: string;
    creditCardNumber: string;
    //List<Invoice> invoiceList:

    public constructor(init?: Partial<Customer>) {
        Object.assign(this, init);
    }
}