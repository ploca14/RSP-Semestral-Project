import { faker } from "@faker-js/faker";

export interface Actor {
  id: string;
  firstName: string;
  lastName: string;
}

export function generateFakeData(): Actor {
  return {
    id: faker.unique(faker.datatype.number).toString(),
    firstName: faker.name.firstName(),
    lastName: faker.name.lastName(),
  };
}