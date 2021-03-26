export class Car {

    vehicleID: string;
    imgURL: string;
    modelName: string;
    manufacturingDate: string;
    propellantType: string;
    kilometerReading: number;
    kilometerReadingCleared: boolean; 
    basicPrice: number;
    description?: string;  //optional
    availableForRent: boolean;
    seatNumber: number;
    seatCover: string;
    color: string;
    navigationSystem: boolean;
    autoPilot: boolean;
    temperatureControlSystem: boolean;
    safetySystem: boolean;
    storageCabinet: boolean;

}