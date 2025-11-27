describe('User Registration', () => {

  it('should successfully register a user', () => {

    cy.visit('http://localhost:9191/register');

    cy.get('input[name="name"]').type('Test User 2');
    cy.get('input[name="email"]').type('testuser2@example.com');
    cy.get('input[name="password"]').type('1234567');
    cy.get('select[name="role"]').select('CLIENT');

    cy.get('button[type="submit"]').click();

    cy.url().should('include', '/login');
  });

});
