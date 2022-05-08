import { faker } from "@faker-js/faker";

export interface Musical {
  id: string;
  imageSource: string;
  name: string;
}

export function generateFakeData(): Musical {
  return {
    id: faker.unique(faker.datatype.number).toString(),
    imageSource: faker.image.animals(480, 270, true),
    name: faker.lorem.words(3),
  };
}