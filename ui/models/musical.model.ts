import { faker } from "@faker-js/faker";

export interface Musical {
  id: number;
  imageSource: string;
  name: string;
}

export function generateFakeData(): Musical {
  return {
    id: faker.unique(faker.datatype.number),
    imageSource: faker.image.animals(480, 270, true),
    name: faker.lorem.words(3),
  };
}