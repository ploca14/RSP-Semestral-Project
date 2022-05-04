import { faker } from "@faker-js/faker";

export interface Actor {
  id: number;
  name: string;
}

export function generateFakeData(): Actor {
  return {
    id: faker.unique(faker.datatype.number),
    name: faker.name.findName(),
  };
}