import { Pipe, PipeTransform } from '@angular/core';

@Pipe({ name: 'booleanDetailsPipe' })
export class BooleanDetailsPipe implements PipeTransform {

    transform(value: boolean, args?: string) {
        if (value === null) {
            return 'n.a.';
        } else if (value) {
            return 'Yes';
        } else {
            return "No";
        }
    }
}